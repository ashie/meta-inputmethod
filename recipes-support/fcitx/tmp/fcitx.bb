# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYING
#   COPYING.LIBS
#   cmake/COPYING-CMAKE-SCRIPTS
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6306e547e5c5e43190193019ed46ee13 \
                    file://COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
                    file://COPYING.LIBS;md5=e7a3d1af143519ecc617f1f95537934b \
                    file://cmake/COPYING-CMAKE-SCRIPTS;md5=2d149a0f4588c9f5e60c729e786dad45"

SRC_URI = "http://download.fcitx-im.org/fcitx/fcitx-${PV}.tar.xz"
SRC_URI[md5sum] = "8abea7dd25d41436520e50ae61a4c751"
SRC_URI[sha256sum] = "25661907903e4ccaa4cf62cc389c006e280d31bce84147e203d7310fb4cd42ed"

# NOTE: unable to map the following CMake package dependencies: GettextPo Presage DL OpenCC IsoCodes Enchant Qt4 Libexecinfo Lua Libintl XkbFile XKBCommon Libkvm ECM
DEPENDS = "glib-2.0 pango dbus-glib libx11 cairo gtk+ libxml2 gtk+3 dbus fontconfig virtual/libiconv"

inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

