# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://salsa.debian.org/iso-codes-team/iso-codes.git;protocol=https"

# Modify these as desired
PV = "3.79+git${SRCPV}"
SRCREV = "68e7285932d9296d901056354b22d99f3a6a9a82"

S = "${WORKDIR}/git"

# NOTE: the following prog dependencies are unknown, ignoring: recode-sr-latin msgfmt msgmerge msgattrib msgfilter

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES_${PN} = "${datadir}/xml/iso-codes/* \
		${datadir}/iso-codes/* \
"
