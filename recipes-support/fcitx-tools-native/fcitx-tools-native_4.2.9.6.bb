LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=6306e547e5c5e43190193019ed46ee13 \
    file://COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
    file://COPYING.LIBS;md5=e7a3d1af143519ecc617f1f95537934b \
    file://cmake/COPYING-CMAKE-SCRIPTS;md5=2d149a0f4588c9f5e60c729e786dad45 \
"

SRC_URI = "http://download.fcitx-im.org/fcitx/fcitx-${PV}.tar.xz"
SRC_URI[md5sum] = "88631df4af0b8d9fc7a816dd135fa97b"
SRC_URI[sha256sum] = "d55eee3f094037b5c32f0c5397d585fdf932cbc7d2091ed6f78fd7a9ae512c47"

DESCRIPTION = "A multilingual user input method library (build phase tools only)"
HOMEPAGE = "https://fcitx-im.org/wiki/Fcitx"
SECTION = "inputmethods"
S = "${WORKDIR}/fcitx-${PV}/"

SRC_URI += " \
    file://enable-pic.patch \
    file://only-native-tool.patch \
"

FILESEXTRAPATHS =. "${FILE_DIRNAME}/fcitx-tools:"

DEPENDS = "libxkbcommon libxkbfile extra-cmake-modules gettext"

inherit cmake pkgconfig gettext native

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE += " \
    -DENABLE_XDGAUTOSTART=OFF \
    -DDATADIR=${datadir} \
    -DDOCSDIR=${docsdir} \
    -DGOBJECT_INTROSPECTION_GIRDIR=${D}/usr/share/gir-1.0 \
    -DGOBJECT_INTROSPECTION_TYPELIBDIR=${D}/usr/lib/girepository-1.0 \
    -DMANPREFIX=${MANPREFIX} \
    -DPREFIX=/usr/ -DLIB_INSTALL_DIR=$=/usr/lib \
    -DENABLE_QT_IM_MODULE=OFF \
    -DENABLE_GTK3_IM_MODULE=OFF -DENABLE_GTK2_IM_MODULE=OFF \
    -DFCITX_TOOL_CROSS_COMPILE=On \
    -DENABLE_SPELL=On \
    -DFORCE_ENCHANT=On -DENABLE_GETTEXT=Off \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT}/ \
    -DENABLE_QT=OFF -DENABLE_QT_IM_MODULE=OFF -DENABLE_QT_GUI=OFF \
"

CONFIGUREOPTS_remove_class-target = "--disable-silent-rules"

do_compile() {
    make fcitx-scanner fcitx-po-parser txt2mb comp-spell-dict createPYMB
}

do_install() {
    install -d ${D}/${libdir}/fcitx/libexec
    install -m 744 tools/dev/fcitx-po-parser ${D}/${libdir}/fcitx/libexec
    install -m 744 tools/dev/fcitx-scanner ${D}/${libdir}/fcitx/libexec
    install -m 744 tools/cli/txt2mb ${D}/${libdir}/fcitx/libexec
    install -m 744 tools/cli/createPYMB ${D}/${libdir}/fcitx/libexec
    install -m 744 src/module/spell/dict/comp-spell-dict ${D}/${libdir}/fcitx/libexec
    install -m 644 src/lib/fcitx-config/libfcitx-config.so* ${D}/${libdir}
    install -m 644 src/lib/fcitx-utils/libfcitx-utils.so* ${D}/${libdir}
}

BBCLASSEXTEND = "native nativesdk"
