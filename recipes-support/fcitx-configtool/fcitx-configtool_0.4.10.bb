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

DEPENDS = "fcitx gtk+3 gtk+ fcitx-tools-native glib-2.0-native"
RDPENDS = "fcitx-bin fcitx-data fcitx-modules fcitx-module-gtk3 libfcitx-gclient0"

SRC_URI = "https://gitlab.com/fcitx/fcitx-configtool/-/archive/${PV}/fcitx-configtool-${PV}.tar.bz2"
SRC_URI[md5sum] = "fcd7e2238c5bdddb77098699025719ce"
SRC_URI[sha256sum] = "3b33797e561e44615bf4130900524f1c94abfd76b3fc482a49dca415aa309b10"

S = "${WORKDIR}/${PN}-${PV}/"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DMAKE_INSTALL_PREFIX=/usr \
    -DENABLE_GTK2=On \
    -DENABLE_GTK3=On \
"
