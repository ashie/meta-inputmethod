LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=af88d758f75f3c5c48a967501f24384b \
                    file://doc/python-license.txt;md5=d214581529e343354f8e23025bdf582d"

SRC_URI = "https://github.com/fmtlib/fmt/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "2522ec65070c0bda0ca288677ded2831"
SRC_URI[sha1sum] = "5936a766e3754fdfa4131bf892916c23d972b5ae"
SRC_URI[sha256sum] = "5cae7072042b3043e12d53d50ef404bbb76949dad1de368d7f993a15c8c05ecc"
SRC_URI[sha384sum] = "146ec21f736dd455c54d46a0bcceb3862caacfabef3d187717b660dadd1c129d96af6552c11bd01c03ede2cc0d381c53"
SRC_URI[sha512sum] = "cfb2431de822202f17a6f34a302b1922b9cd696d8d4c27ad50ea08add781d2af9944db987603c2eb294ee7d73054a60cc11d3a0693f7f6db61949f3041cb9517"

inherit cmake python3native

BBCLASSEXTEND = "native"

EXTRA_OECMAKE = ""

FILES_${PN}-dev += "${libdir}/cmake/fmt"
