# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=00ed06f01bcb1983382068710eb131c4"

DEPENDS = "fcitx anthy fcitx-tools-native"
RDPENDS = "fcitx-bin fcitx-data fcitx-modules libanthy0 anthy"

SRC_URI = "https://gitlab.com/fcitx/fcitx-anthy/-/archive/${PV}/fcitx-anthy-${PV}.tar.bz2"
SRC_URI[md5sum] = "5b5550733b5bdf5f0be2b877c4d7354a"
SRC_URI[sha256sum] = "5020106e337f152433e6181e632acd77b9167ddc01fc685ba78878e547cbed47"

S = "${WORKDIR}/${PN}-${PV}/"

inherit cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE += "-DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DMAKE_INSTALL_PREFIX=/usr \
    -DFCITX_TOOL_BINARY_DIR=${RECIPE_SYSROOT_NATIVE}/${libdir}/fcitx/ \
"

FILES_${PN} += "${libdir}/fcitx/fcitx-anthy.so \
    ${datadir}/icons \
    ${datadir}/fcitx \
"
