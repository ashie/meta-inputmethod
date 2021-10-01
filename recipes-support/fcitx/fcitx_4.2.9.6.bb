LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=6306e547e5c5e43190193019ed46ee13 \
                    file://COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
                    file://COPYING.LIBS;md5=e7a3d1af143519ecc617f1f95537934b \
                    file://cmake/COPYING-CMAKE-SCRIPTS;md5=2d149a0f4588c9f5e60c729e786dad45"

SRC_URI = "http://download.fcitx-im.org/fcitx/fcitx-${PV}.tar.xz"
SRC_URI[md5sum] = "88631df4af0b8d9fc7a816dd135fa97b"
SRC_URI[sha256sum] = "d55eee3f094037b5c32f0c5397d585fdf932cbc7d2091ed6f78fd7a9ae512c47"

DESCRIPTION = "A multilingual user input method library"
HOMEPAGE = "https://fcitx-im.org/wiki/Fcitx"
SECTION = "inputmethods"

_DICT_VER=      "20121020"
_PYSTROKE_VER=  "20121124"
_PYTABLE_VER=   "20121124"

SRC_URI += " \
           http://download.fcitx-im.org/data/pinyin.tar.gz;name=pinyin \
           http://download.fcitx-im.org/data/table.tar.gz;name=table \
           http://download.fcitx-im.org/data/py_stroke-${_PYSTROKE_VER}.tar.gz;name=py_stroke \
           http://download.fcitx-im.org/data/py_table-${_PYTABLE_VER}.tar.gz;name=py_table \
           http://download.fcitx-im.org/data/en_dict-${_DICT_VER}.tar.gz;name=en_dict \
           file://0001-Add-fPIC-to-CFLAGS-and-CXXFLAGS.patch \
           file://0002-Use-precompiled-building-tools.patch \
           file://0003-Add-CMAKE_SYSROOT-for-paths-for-cmake-macros.patch \
           file://0004-Force-set-configuration-directories.patch \
           file://0005-Add-NoUI-module.patch \
           file://0006-fcitx-Don-t-build-dev-tools.patch \
           file://0007-Avoid-to-add-CMAKE_SYSROOT-to-ISOCODES_ISO-_XML.patch \
           file://0008-Use-LIB_INSTALL_DIR-instead-of-CMAKE_INSTALL_PREFIX-.patch \
"

SRC_URI[pinyin.md5sum] = "34dcb1b5209c28baa4e87f6a2773bfd0"
SRC_URI[pinyin.sha256sum] = "583829b24a758c087c08de4a69480d0bf5946354fe77db360d6d7f467c2bd8e1"

SRC_URI[table.md5sum] = "acb0b112423474ab2c1a22cee590d636"
SRC_URI[table.sha256sum] = "6196053c724125e3ae3d8bd6b2f9172d0c83b65b0d410d3cde63b7a8d6ab87b7"

SRC_URI[py_stroke.md5sum] = "2559d025c5bbb50fa450a02429f92762"
SRC_URI[py_stroke.sha256sum] = "8eb128a9bfa43952e67cf2fcee1fd134c6f4cfd317bc2f6c38a615f5eb64e248"

SRC_URI[py_table.md5sum] = "a72e275fe1916d67d01a2f038ca5d920"
SRC_URI[py_table.sha256sum] = "42146ac97de6c13d55f9e99ed873915f4c66739e9c11532a34556badf9792c04"

SRC_URI[en_dict.md5sum] = "8315f85331e0545c256a46e0cb00f10f"
SRC_URI[en_dict.sha256sum] = "c44a5d7847925eea9e4d2d04748d442cd28dd9299a0b572ef7d91eac4f5a6ceb"

do_unpack[pinyin.noexec] = "1"
do_unpack[table.noexec] = "1"
do_unpack[py_stroke.noexec] = "1"
do_unpack[py_table.noexec] = "1"
do_unpack[en_dict.noexec] = "1"
do_unpack_extra() {
    cp ${DL_DIR}/pinyin.tar.gz ${S}/src/im/pinyin/data/
    cp ${DL_DIR}/table.tar.gz ${S}/src/im/table/data
    cp ${DL_DIR}/py_stroke-${_PYSTROKE_VER}.tar.gz ${S}/src/module/pinyin-enhance/data/
    cp ${DL_DIR}/py_table-${_PYTABLE_VER}.tar.gz ${S}/src/module/pinyin-enhance/data/
    cp ${DL_DIR}/en_dict-${_DICT_VER}.tar.gz ${S}/src/module/spell/dict/
}
addtask unpack_extra after do_unpack before do_patch

# NOTE: unable to map the following CMake package dependencies: GettextPo Presage DL OpenCC IsoCodes Enchant Qt4 Libexecinfo Lua Libintl XkbFile XKBCommon Libkvm ECM
DEPENDS = "gettext-native glib-2.0 glib-2.0-native pango dbus-glib libx11 cairo gtk+ libxml2 gtk+3 dbus fontconfig virtual/libiconv extra-cmake-modules takao-fonts libxkbcommon enchant iso-codes libxkbfile fcitx-tools-native xkeyboard-config"

inherit cmake pkgconfig binconfig

BINCONFIG = "${bindir}/fcitx4-config"
BINCONFIG_GLOB = "fcitx4-config"

inherit cmake gtk-immodules-cache
GTKIMMODULES_PACKAGES = "fcitx-gtk2.0 fcitx-gtk3"

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE += "-DENABLE_XDGAUTOSTART=OFF -DFORCE_ENCHANT=ON \
                -DDATADIR=${datadir} \
                -DLIB_INSTALL_DIR=${libdir} \
                -DDOCSDIR=${docsdir} \
                -DGOBJECT_INTROSPECTION_GIRDIR=${D}/usr/share/gir-1.0 \
                -DGOBJECT_INTROSPECTION_TYPELIBDIR=${D}/usr/lib/girepository-1.0 \
                -DMANPREFIX=${MANPREFIX} \
                -DPREFIX=/usr/ \
                -DQT_PLUGINS_DIR=/usr/lib/qt4/plugins \
                -DENABLE_GIR=OFF -DENABLE_GTK3_IM_MODULE=ON \
		-DENABLE_QT=OFF -DENABLE_QT_IM_MODULE=OFF -DENABLE_QT_GUI=OFF \
                -DFCITX_TOOL_BINARY_DIR=${STAGING_LIBDIR_NATIVE}/fcitx/ \
"

CONFIGUREOPTS_remove_class-target = "--disable-silent-rules"

do_install_append() {
    install -m 0744 ${S}/data/script/fcitx-autostart ${D}/${bindir}/fcitx-autostart
    rm -rf ${D}/${datadir}/applications
}

PACKAGES =+ "fcitx-tools fcitx-libs fcitx-data fcitx-ui-classic fcitx-noui fcitx-modules fcitx-module-x11 fcitx-module-dbus fcitx-module-kimpanel \
fcitx-table fcitx-gtk2.0 fcitx-gtk3 fcitx-pinyin fcitx-gclient fcitx-qw fcitx-table-bingchan fcitx-table-cangjie \
fcitx-table-dianbaoma fcitx-table-erbi fcitx-table-wanfeng fcitx-table-wbpy fcitx-table-wubi fcitx-table-ziranma \
fcitx-ipcportal \
"

FILES_${PN} = "${bindir}/fcitx \
    ${bindir}/fcitx-autostart \
    ${bindir}/fcitx-configtool \
    ${bindir}/fcitx-diagnose \
    ${bindir}/fcitx-remote \
    ${bindir}/fcitx-dbus-watcher \
    ${bindir}/fcitx-skin-installer \
    ${bindir}/fcitx4-config \
    ${libdir}/fcitx/libexec/comp-spell-dict \
    ${libdir}/fcitx/libexec/fcitx-scanner \
    ${libdir}/fcitx/libexec/fcitx-po-parser \
    ${datadir}/dbus-1/services/org.fcitx.Fcitx.service \
    ${datadir}/fcitx/data/env_setup.sh \
"

FILES_${PN}-gtk2.0 = "${libdir}/gtk-2.0/2.10.0/immodules/im-fcitx.so"
FILES_${PN}-gtk3 = "${libdir}/gtk-3.0/3.0.0/immodules/im-fcitx.so"

FILES_${PN}-tools = "${bindir}/createPYMB \
    ${bindir}/mb2org \
    ${bindir}/mb2txt \
    ${bindir}/readPYBase \
    ${bindir}/readPYMB \
    ${bindir}/scel2org \
    ${bindir}/txt2mb \
"

RDEPENDS_${PN} = "fcitx-libs iso-codes"
RDEPENDS_${PN}-tools = "fcitx-libs"
RDEPENDS_${PN}-gtk2.0 = "fcitx-libs"
RDEPENDS_${PN}-gtk3 = "fcitx-libs"
RDEPENDS_${PN}-gclient = "fcitx-libs"

FILES_${PN}-table = "${libdir}/fcitx/fcitx-table.so \
   ${datadir}/fcitx/addon/fcitx-table.conf \
   ${datadir}/fcitx/configdesc/fcitx-table.desc \
   ${datadir}/fcitx/configdesc/table.desc \
"

FILES_${PN}-data = "${datadir}/fcitx/configdesc/addon.desc \
   ${datadir}/fcitx/configdesc/config.desc \
   ${datadir}/fcitx/configdesc/inputmethod.desc \
   ${datadir}/fcitx/configdesc/profile.desc \
   ${datadir}/fcitx/configdesc/skin.desc \
   ${datadir}/fcitx/imicon/*.png \
   ${datadir}/icons/hicolor/128x128/apps/*.png \
   ${datadir}/icons/hicolor/16x16/apps/*.png \
   ${datadir}/icons/hicolor/22x22/apps/*.png \
   ${datadir}/icons/hicolor/24x24/apps/*.png \
   ${datadir}/icons/hicolor/32x32/apps/*.png \
   ${datadir}/icons/hicolor/48x48/apps/*.png \
   ${datadir}/icons/hicolor/scalable/apps/*.svg\
   ${datadir}/mime/packages/x-fskin.xml \
   ${datadir}/fcitx/data/quickphrase.d/emoji-eac.mb \
"

FILES_${PN}-ui-classic = "${libdir}/fcitx/fcitx-classic-ui.so \
    ${libdir}/fcitx/fcitx-notificationitem.so \
    ${datadir}/fcitx/skin/classic/*.conf \
    ${datadir}/fcitx/skin/classic/*.png \
    ${datadir}/fcitx/skin/dark/*.png \
    ${datadir}/fcitx/skin/dark/*.conf \
    ${datadir}/fcitx/skin/default/*.png \
    ${datadir}/fcitx/skin/default/*.conf \  
    ${datadir}/fcitx/addon/fcitx-classic-ui.conf \
    ${datadir}/fcitx/addon/fcitx-notificationitem.conf \
    ${datadir}/fcitx/configdesc/fcitx-classic-ui.desc \
"

FILES_${PN}-noui = "${libdir}/fcitx/fcitx-no-ui.so \
    ${datadir}/fcitx/addon/fcitx-no-ui.conf \
"

FILES_${PN}-modules = "${libdir}/fcitx/fcitx-autoeng.so \
    ${libdir}/fcitx/fcitx-chttrans.so \
    ${libdir}/fcitx/fcitx-clipboard.so \
    ${libdir}/fcitx/fcitx-fullwidth-char.so \
    ${libdir}/fcitx/fcitx-imselector.so \
    ${libdir}/fcitx/fcitx-keyboard.so \
    ${libdir}/fcitx/fcitx-punc.so \
    ${libdir}/fcitx/fcitx-quickphrase.so \
    ${libdir}/fcitx/fcitx-remote-module.so \
    ${libdir}/fcitx/fcitx-spell.so \
    ${libdir}/fcitx/fcitx-unicode.so \
    ${datadir}/fcitx/addon/fcitx-autoeng.conf \
    ${datadir}/fcitx/addon/fcitx-chttrans.conf \
    ${datadir}/fcitx/addon/fcitx-clipboard.conf \
    ${datadir}/fcitx/addon/fcitx-fullwidth-char.conf \
    ${datadir}/fcitx/addon/fcitx-imselector.conf \
    ${datadir}/fcitx/addon/fcitx-keyboard.conf \
    ${datadir}/fcitx/addon/fcitx-punc.conf \
    ${datadir}/fcitx/addon/fcitx-quickphrase.conf \
    ${datadir}/fcitx/addon/fcitx-remote-module.conf \
    ${datadir}/fcitx/addon/fcitx-spell.conf \
    ${datadir}/fcitx/addon/fcitx-unicode.conf \
    ${datadir}/fcitx/configdesc/fcitx-autoeng.desc \
    ${datadir}/fcitx/configdesc/fcitx-chttrans.desc \
    ${datadir}/fcitx/configdesc/fcitx-clipboard.desc \
    ${datadir}/fcitx/configdesc/fcitx-imselector.desc \
    ${datadir}/fcitx/configdesc/fcitx-keyboard.desc \
    ${datadir}/fcitx/configdesc/fcitx-quickphrase.desc \
    ${datadir}/fcitx/configdesc/fcitx-spell.desc \
    ${datadir}/fcitx/configdesc/fcitx-unicode.desc \
    ${datadir}/fcitx/data/AutoEng.dat \
    ${datadir}/fcitx/data/charselectdata \
    ${datadir}/fcitx/data/gbks2t.tab \
    ${datadir}/fcitx/data/punc.mb.zh_CN \
    ${datadir}/fcitx/data/punc.mb.zh_HK \
    ${datadir}/fcitx/data/punc.mb.zh_TW \
    ${datadir}/fcitx/data/quickphrase.d/emoji.mb \
    ${datadir}/fcitx/data/quickphrase.d/latex.mb \
    ${datadir}/fcitx/spell/en_dict.fscd \
"

FILES_${PN}-module-x11 = "${libdir}/fcitx/fcitx-vk.so \
    ${libdir}/fcitx/fcitx-x11.so \
    ${libdir}/fcitx/fcitx-xim.so \
    ${libdir}/fcitx/fcitx-xkb.so \
    ${libdir}/fcitx/fcitx-xkbdbus.so \
    ${datadir}/fcitx/addon/fcitx-vk.conf \
    ${datadir}/fcitx/addon/fcitx-x11.conf \
    ${datadir}/fcitx/addon/fcitx-xim.conf \
    ${datadir}/fcitx/addon/fcitx-xkb.conf \
    ${datadir}/fcitx/addon/fcitx-xkbdbus.conf \
    ${datadir}/fcitx/configdesc/fcitx-xim.desc \
    ${datadir}/fcitx/configdesc/fcitx-xkb.desc \
    ${datadir}/fcitx/data/vk.conf \
"

FILES_${PN}-module-dbus = "${libdir}/fcitx/fcitx-dbus.so \
    ${libdir}/fcitx/fcitx-freedesktop-notify.so \
    ${libdir}/fcitx/fcitx-ipc.so \
    ${datadir}/fcitx/addon/fcitx-dbus.conf \
    ${datadir}/fcitx/addon/fcitx-freedesktop-notify.conf \
    ${datadir}/fcitx/addon/fcitx-ipc.conf \
    ${datadir}/fcitx/dbus/daemon.conf \
"

FILES_${PN}-module-kimpanel = "${libdir}/fcitx/fcitx-kimpanel-ui.so \
    ${datadir}/fcitx/addon/fcitx-kimpanel-ui.conf \
"

FILES_${PN}-ipcportal = "${libdir}/fcitx/fcitx-ipcportal.so \
    ${datadir}/fcitx/addon/fcitx-ipcportal.conf \
"

FILES_${PN}-pinyin = "${libdir}/fcitx/fcitx-pinyin-enhance.so \
    ${libdir}/fcitx/fcitx-pinyin.so \
    ${datadir}/fcitx/addon/fcitx-pinyin-enhance.conf \ 
    ${datadir}/fcitx/addon/fcitx-pinyin.conf \
    ${datadir}/fcitx/configdesc/fcitx-pinyin-enhance.desc \
    ${datadir}/fcitx/configdesc/fcitx-pinyin.desc \
    ${datadir}/fcitx/inputmethod/pinyin.conf \
    ${datadir}/fcitx/inputmethod/shuangpin.conf \
    ${datadir}/fcitx/pinyin/pybase.mb \
    ${datadir}/fcitx/pinyin/pyphrase.mb \
    ${datadir}/fcitx/py-enhance/py_stroke.mb \
    ${datadir}/fcitx/py-enhance/py_table.mb \
    ${datadir}/fcitx/pinyin/pySym.mb \
    ${datadir}/fcitx/pinyin/sp.dat \
"

FILES_${PN}-dev += "${datadir}/cmake/fcitx/*.cmake \
    ${datadir}/cmake/fcitx/*.sh \
    ${datadir}/cmake/fcitx/getdescpo \
"

FILES_${PN}-libs = "${libdir}/libfcitx-config.so.4 \
    ${libdir}/libfcitx-core.so.0 \
    ${libdir}/libfcitx-utils.so.0 \
    ${libdir}/libfcitx-config.so.4.1 \
    ${libdir}/libfcitx-core.so.0.3 \
    ${libdir}/libfcitx-utils.so.0.1 \
"

FILES_${PN}-gclient = "${libdir}/libfcitx-gclient.so.1\
    ${libdir}/libfcitx-gclient.so.0.2 \
"

FILES_${PN}-qw = "${libdir}/fcitx/fcitx-qw.so \
    ${datadir}/fcitx/addon/fcitx-qw.conf \
    ${datadir}/fcitx/inputmethod/qw.conf \
"

FILES_${PN}-table-bingchan = "${datadir}/fcitx/table/qxm.conf \
    ${datadir}/fcitx/table/qxm.mb \
"

FILES_${PN}-table-cangjie = "${datadir}/fcitx/table/cangjie.conf \
    ${datadir}/fcitx/table/cj.mb \
"

FILES_${PN}-table-dianbaoma = "${datadir}/fcitx/table/db.conf \
    ${datadir}/fcitx/table/db.mb \
"

FILES_${PN}-table-erbi = "${datadir}/fcitx/table/erbi.conf \
    ${datadir}/fcitx/table/erbi.mb \
"

FILES_${PN}-table-wanfeng = "${datadir}/fcitx/table/wanfeng.conf \
    ${datadir}/fcitx/table/wanfeng.mb \
"

FILES_${PN}-table-wbpy = "${datadir}/fcitx/table/wbpy.conf \
    ${datadir}/fcitx/table/wbpy.mb \
"

FILES_${PN}-table-wubi = "${datadir}/fcitx/table/wbx.conf \
    ${datadir}/fcitx/table/wbx.mb \
"

FILES_${PN}-table-ziranma = "${datadir}/fcitx/table/zrm.conf \
    ${datadir}/fcitx/table/zrm.mb \
"

FILES_${PN}-dbg += "${libdir}/*/*/*/.debug ${libdir}/*/*/.debug"

PACKAGE_WRITE_DEPS += "qemu-native"
