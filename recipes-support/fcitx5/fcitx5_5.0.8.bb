# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSES/LGPL-2.1-or-later.txt
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5/fcitx5-${PV}_dict.tar.xz"
SRC_URI[sha256sum] = "02f5de5e4d8c9912656b5acf954085ee5cdd567292fc1a915be051f9aed46614"

SRC_URI_append = "\
	file://0001-use-precompiled-tools.patch \
"

# Modify these as desired
S = "${WORKDIR}/${BPN}-${PV}"

# NOTE: unable to map the following CMake package dependencies: WaylandScanner ECM Execinfo WaylandProtocols LibUUID XKBCommon fmt XCBImdkit XKeyboardConfig Systemd DL LibIntl LibKVM Doxygen Libevent IsoCodes Wayland
DEPENDS = " ninja extra-cmake-modules virtual/egl expat dbus fmt \
	libxcb xcb-util xcb-util-keysyms xcb-util-wm xcb-imdkit libxkbcommon libxkbfile\
	wayland wayland-native wayland-protocols iso-codes cairo \
	gdk-pixbuf pango enchant2 json-c systemd fcitx5-tools-native \
"

inherit autotools cmake pkgconfig gettext

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "\
	-DFCITX_TOOL_BINARY_DIR=${RECIPE_SYSROOT_NATIVE}${noarch_libdir}/fcitx5/ \
"
