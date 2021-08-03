# Recipe created by recipetool
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "http://download.savannah.gnu.org/releases/m17n/m17n-db-${PV}.tar.gz" 

SRC_URI[md5sum] = "49378f8ed738f84abfaf5e09699e1fa0"
SRC_URI[sha256sum] = "657f23835b6655e7a63a362bac66260454ee356da4855eadb9366911d33fdc6d"

DEPENDS = "glibc glibc-locale"
RDEPENDS_${PN} += "busybox"

inherit autotools-brokensep pkgconfig gettext

EXTRA_OECONF = "--with-charmaps=${STAGING_DIR_TARGET}${datadir}/i18n/charmaps"

FILES_${PN} += "${bindir}/m17n-db \
    ${datadir}/m17n \
    ${datadir}/locale \
"
do_install_prepend() {
    sed -i -e 's/gawk/awk/g' ${S}/tbl2mim.awk 
}
