# Recipe created by recipetool
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=00ed06f01bcb1983382068710eb131c4"

DEPENDS = "fcitx fcitx-tools-native libhangul"
RDEPENDS_${PN} = "fcitx fcitx-data fcitx-modules libhangul"

SRC_URI = "https://download.fcitx-im.org/fcitx-hangul/fcitx-hangul-${PV}.tar.xz" 

SRC_URI[md5sum] = "32d0480006dce1328025d2d94e8fa4b0"
SRC_URI[sha256sum] = "6dd5fd5956924c85af92ebefaef1e113e38fa814355fbb0f07c26049c3014437"

inherit cmake pkgconfig 

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DMAKE_INSTALL_PREFIX=/usr \
    -DLIB_INSTALL_DIR=${libdir} \
    -DFCITX_TOOL_BINARY_DIR=${STAGING_LIBDIR_NATIVE}/fcitx/ \
"

FILES_${PN} += " \
    ${libdir}/fcitx/fcitx-hangul.so \
    ${datadir}/fcitx \
    ${datadir}/icons \
"
