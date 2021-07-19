LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=2b5d6efa329a623111801f34cc566cd6 \
                    file://doc/python-license.txt;md5=d214581529e343354f8e23025bdf582d"

SRC_URI = "git://github.com/fmtlib/fmt.git;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "a4969ebe063b605e5ca9c6c79dba44dc30f97f2d"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = ""

FILES_${PN} += "\
  /usr/lib/cmake/fmt/fmt-config.cmake \
  /usr/lib/cmake/fmt/fmt-config-version.cmake \
  /usr/lib/cmake/fmt/fmt-targets.cmake \
  /usr/lib/cmake/fmt/fmt-targets-release.cmake \
"






