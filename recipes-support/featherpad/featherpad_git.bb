# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYING
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI = "git://github.com/tsujan/FeatherPad.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "5eb257ae4e61a96f0b62a3d10c7b7edebf5f7d78"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtx11extras qtsvg"

inherit qmake5

FILES_${PN} = "\
	    /usr/share/icons/hicolor/scalable/apps/featherpad.svg \
	    /usr/bin/fpad \
	    /usr/bin/featherpad \
	    /usr/share/applications \
	    /usr/share/featherpad \
	    /usr/share/applications/featherpad.desktop \
	    /usr/share/featherpad/help \
"
