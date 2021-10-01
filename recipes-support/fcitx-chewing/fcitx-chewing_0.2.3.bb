# Recipe created by recipetool
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=00ed06f01bcb1983382068710eb131c4"

DEPENDS = "fcitx fcitx-tools-native libchewing"
RDEPENDS_${PN} = "fcitx fcitx-data fcitx-modules libchewing sqlite3"

SRC_URI = "https://download.fcitx-im.org/fcitx-chewing/fcitx-chewing-${PV}.tar.xz"

SRC_URI[md5sum] = "6d331e7abb439ac8d1e7538ae94f53d2"
SRC_URI[sha256sum] = "b313c7134eb173668f42535b0eb6e985eb94fdf5d2fe705940a6cbfdcbadbaf0"

inherit cmake pkgconfig 

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DMAKE_INSTALL_PREFIX=/usr \
    -DLIB_INSTALL_DIR=${libdir} \
    -DFCITX_TOOL_BINARY_DIR=${STAGING_LIBDIR_NATIVE}/fcitx/ \
"

FILES_${PN} += "${libdir}/fcitx/fcitx-chewing.so \
	${datadir}/fcitx \
	${datadir}/icons \
"
