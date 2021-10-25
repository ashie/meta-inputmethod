LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=8be7367f7e5d605a426f76bb37d4d61f"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libxkbfile.git;protocol=https"

PV = "1.0.9+git${SRCPV}"
SRCREV = "d2ec504fec2550f4fd046e801b34317ef4a4bab9"

S = "${WORKDIR}/git"

DEPENDS = "libx11"

inherit pkgconfig autotools

EXTRA_OECONF = ""

