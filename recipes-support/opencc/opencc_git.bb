LICENSE = "Apache-2.0 & BSD-2-Clause &  BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a53192195ed45e801ce0642da66d65a7 \
                    file://deps/google-benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://deps/gtest-1.11.0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://deps/marisa-0.2.6/COPYING.md;md5=436b518598dca3cb23d801bd12d59826 \
                    file://deps/pybind11-2.5.0/LICENSE;md5=beb87117af69fd10fbf9fb14c22a2e62"

SRC_URI = "git://github.com/BYVoid/OpenCC/;protocol=https"

PV = "1.1.2+git${SRCPV}"
SRCREV = "ea2f79a6938f5ef76cc3d17c8965a5eeacadbf6e"

S = "${WORKDIR}/git"

DEPENDS = "python3 opencc-tools-native "

inherit setuptools cmake

RDEPENDS_${PN} += "python-core"

EXTRA_OECMAKE = " \
    -DLIB_INSTALL_DIR=${libdir} \
"
