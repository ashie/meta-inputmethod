LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5/fcitx5-${PV}_dict.tar.xz"
SRC_URI[sha256sum] = "02f5de5e4d8c9912656b5acf954085ee5cdd567292fc1a915be051f9aed46614"

SRC_URI_append = "\
	file://0001-Don-t-use-charconv-to-support-GCC-7.x.patch \
	file://0002-Add-CMAKE_SYSROOT-for-xkb_base.patch \
	file://0003-Add-options-to-disable-XIM-IBus-frontend.patch \
	file://0004-Add-an-option-to-disable-AppStream-metainfo.patch \
	file://0005-Avoid-to-add-CMAKE_SYSROOT-to-ISOCODES_ISO-_JSON.patch \
        file://0006-Tweak-include-directories-to-care-CMAKE_SYSROOT.patch \
        file://0007-Make-sure-to-get-global-registry.patch \
"

# Modify these as desired
S = "${WORKDIR}/${BPN}-${PV}"

# NOTE: unable to map the following CMake package dependencies: WaylandScanner ECM Execinfo WaylandProtocols LibUUID XKBCommon fmt XCBImdkit XKeyboardConfig Systemd DL LibIntl LibKVM Doxygen Libevent IsoCodes Wayland
DEPENDS = " ninja-native extra-cmake-modules virtual/egl expat dbus fmt \
	libxcb xcb-util xcb-util-keysyms xcb-util-wm xcb-imdkit libxkbcommon libxkbfile\
	wayland wayland-native wayland-protocols iso-codes cairo \
	gdk-pixbuf pango enchant2 json-c systemd fcitx5-tools-native xkeyboard-config \
"

inherit cmake pkgconfig gettext

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "\
	-DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
	-DENABLE_TEST=OFF \
	-DENABLE_IBUS=OFF \
	-DENABLE_METAINFO=OFF \
"

do_configure_append() {
    # Someone put unexpected "-I/usr/include" for building xim module but we
    # don't yet find who does it.
    sed -i -e "s# -I/usr/include # #g" ${B}/build.ninja
}

FILES_${PN} += " \
   ${datadir}/icons/hicolor/128x128/apps/*.png \
   ${datadir}/icons/hicolor/16x16/apps/*.png \
   ${datadir}/icons/hicolor/22x22/apps/*.png \
   ${datadir}/icons/hicolor/24x24/apps/*.png \
   ${datadir}/icons/hicolor/32x32/apps/*.png \
   ${datadir}/icons/hicolor/48x48/apps/*.png \
   ${datadir}/icons/hicolor/scalable/apps/*.svg \
   ${datadir}/dbus-1/services/org.fcitx.Fcitx5.service \
"
