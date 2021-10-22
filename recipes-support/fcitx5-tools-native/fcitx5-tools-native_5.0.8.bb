LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5/fcitx5-${PV}_dict.tar.xz"
SRC_URI[sha256sum] = "02f5de5e4d8c9912656b5acf954085ee5cdd567292fc1a915be051f9aed46614"

SRC_URI_append = "\
    file://0001-Don-t-use-charconv-to-support-GCC-7.x.patch \
    file://0004-Add-an-option-to-disable-AppStream-metainfo.patch \
"

S = "${WORKDIR}/fcitx5-${PV}"

FILESEXTRAPATHS =. "${FILE_DIRNAME}/fcitx5-tools:"

Systemd DL LibIntl LibKVM Doxygen Libevent IsoCodes Wayland

DEPENDS = "extra-cmake-modules fmt libevent enchant2 gettext"

inherit cmake pkgconfig gettext native

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE = " \
    -DENABLE_TEST=OFF \
    -DENABLE_COVERAGE=OFF \
    -DENABLE_X11=OFF \
    -DENABLE_WAYLAND=OFF \
    -DENABLE_DBUS=OFF \
    -DENABLE_KEYBOARD=OFF \
    -DUSE_SYSTEMD=OFF \
    -DENABLE_XDGAUTOSTART=OFF \
    -DENABLE_EMOJI=OFF \
    -DENABLE_LIBUUID=OFF \
    -DENABLE_METAINFO=OFF \
    -DDL_INCLUDE_DIR=/usr/include \
    -DLibIntl_INCLUDE_DIR=/usr/include \
    -DPTHREAD_INCLUDE_DIR=/usr/include \
    -DPTHREAD_LIB_FOUND=/usr/lib \
"

LDFLAGS_append = ",--no-as-needed -ldl "

do_compile() {
    cmake --build ${B} --target Fcitx5Utils
    cmake --build ${B} --target Fcitx5Config
    cmake --build ${B} --target comp-spell-dict
}

do_install() {
    DESTDIR=${D} make install -C src/lib/fcitx-utils
    DESTDIR=${D} make install -C src/lib/fcitx-config
    install -d ${D}/${bindir}
    install -d ${D}/${libdir}/cmake/Fcitx5Utils
    install -m 755 src/modules/spell/dict/comp-spell-dict ${D}/${bindir}/Fcitx5::comp-spell-dict
    install -m 644 src/lib/fcitx-utils/libFcitx5Utils.so* ${D}/${libdir}
    install -m 644 src/lib/fcitx-config/libFcitx5Config.so* ${D}/${libdir}
    install -m 644 ${S}/cmake/Fcitx5CompilerSettings.cmake ${D}/${libdir}/cmake/Fcitx5Utils
}

BBCLASSEXTEND = "native nativesdk"
