LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://salsa.debian.org/iso-codes-team/iso-codes.git;protocol=https;branch=main"

PV = "3.79+git${SRCPV}"
SRCREV = "68e7285932d9296d901056354b22d99f3a6a9a82"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = ""

FILES_${PN} = " \
    ${datadir}/xml/iso-codes/* \
    ${datadir}/iso-codes/* \
"
