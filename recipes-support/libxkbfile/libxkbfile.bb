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
LIC_FILES_CHKSUM = "file://COPYING;md5=8be7367f7e5d605a426f76bb37d4d61f"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libxkbfile.git;protocol=https"

# Modify these as desired
PV = "1.0.9+git${SRCPV}"
SRCREV = "d2ec504fec2550f4fd046e801b34317ef4a4bab9"

S = "${WORKDIR}/git"

DEPENDS = "kbproto libx11"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

