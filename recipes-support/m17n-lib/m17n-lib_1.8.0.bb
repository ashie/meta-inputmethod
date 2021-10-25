# Recipe created by recipetool
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = " \
    http://download.savannah.gnu.org/releases/m17n/m17n-lib-${PV}.tar.gz \
    file://fix-gettext.patch \
"

SRC_URI[md5sum] = "35a7c29b4c5892c643153eeaefd1f787"
SRC_URI[sha256sum] = "78bacae7451822dfff62482ce4f9433c5ae82846e4c64b590541e29e800fe64a"

inherit autotools-brokensep pkgconfig gettext

DEPENDS += "m17n-db gd freetype libxt libxmu libxml2 libxaw libx11 fribidi"
RDEPENDS_${PN} += "m17n-db"

PARALLEL_MAKE = "-j1"

FILES_${PN} += "${libdir}/m17n/1.0/*.so"
FILES_${PN}-staticdev += "${libdir}/m17n/1.0/*.a"
