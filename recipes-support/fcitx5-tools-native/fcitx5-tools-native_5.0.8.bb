LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5/fcitx5-${PV}_dict.tar.xz"
SRC_URI[sha256sum] = "02f5de5e4d8c9912656b5acf954085ee5cdd567292fc1a915be051f9aed46614"

SRC_URI_append = "\
	file://0001-Don-t-use-charconv-to-support-GCC-7.x.patch \
"

# Modify these as desired
S = "${WORKDIR}/fcitx5-${PV}"

FILESEXTRAPATHS =. "${FILE_DIRNAME}/fcitx5-tools:"

# NOTE: unable to map the following CMake package dependencies: WaylandScanner ECM Execinfo WaylandProtocols LibUUID XKBCommon fmt XCBImdkit XKeyboardConfig Systemd DL LibIntl LibKVM Doxygen Libevent IsoCodes Wayland

DEPENDS = "ninja extra-cmake-modules fmt libevent enchant2 gettext"

inherit cmake pkgconfig gettext native

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
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
	-DDL_INCLUDE_DIR=/usr/include \
	-DLibIntl_INCLUDE_DIR=/usr/include \
	-DPTHREAD_INCLUDE_DIR=/usr/include \
	-DPTHREAD_LIB_FOUND=/usr/lib \
"

LDFLAGS_append = ",--no-as-needed -ldl "

do_compile() {
	ninja Fcitx5Config comp-spell-dict
}

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${libdir}
	install -m 744 src/modules/spell/dict/comp-spell-dict ${D}/${bindir}/Fcitx5::comp-spell-dict
	install -m 644 src/lib/fcitx-utils/libFcitx5Utils.so* ${D}/${libdir}
	install -m 644 src/lib/fcitx-config/libFcitx5Config.so* ${D}/${libdir}
}

BBCLASSEXTEND = "native nativesdk"
