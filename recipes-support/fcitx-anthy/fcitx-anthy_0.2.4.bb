LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=00ed06f01bcb1983382068710eb131c4"

DEPENDS = "fcitx anthy fcitx-tools-native"
RDEPENDS_${PN} = "fcitx fcitx-data fcitx-modules libanthy0 anthy"

SRC_URI = "https://download.fcitx-im.org/fcitx-anthy/fcitx-anthy-${PV}.tar.xz"
SRC_URI[md5sum] = "01eea99ce3e1cdc41f881f1cd422ca0d"
SRC_URI[sha256sum] = "1f186cd915ee15ffdb85ccdc437f998fe808dfe6780447c8ccc21f50e50d5fb3"

S = "${WORKDIR}/${PN}-${PV}/"

inherit cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DMAKE_INSTALL_PREFIX=/usr \
    -DLIB_INSTALL_DIR=${libdir} \
    -DFCITX_TOOL_BINARY_DIR=${STAGING_LIBDIR_NATIVE}/fcitx/ \
"

FILES_${PN} += "${libdir}/fcitx/fcitx-anthy.so \
    ${datadir}/icons \
    ${datadir}/fcitx \
"
