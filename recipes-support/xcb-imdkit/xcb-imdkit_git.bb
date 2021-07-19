LICENSE = "LGPLv2.1 & Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://src/xlibi18n/lcUniConv/COPYRIGHT;md5=2715cd5c86722a098d6b97148d1e6936"

SRC_URI = "git://gitlab.com/fcitx/xcb-imdkit.git;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "b82eddb3432b25f0db4aa7db4f68c6744ad895c1"

S = "${WORKDIR}/git"

DEPENDS = "libxcb extra-cmake-modules xcb-util-keysyms xcb-util"

inherit cmake

EXTRA_OECMAKE = ""

FILES_${PN} += "\
  /usr/lib/cmake/XCBImdkit/XCBImdkitLibraryTargets.cmake \
  /usr/lib/cmake/XCBImdkit/XCBImdkitLibraryTargets-noconfig.cmake \
  /usr/lib/cmake/XCBImdkit/XCBImdkitConfig.cmake \
  /usr/lib/cmake/XCBImdkit/XCBImdkitConfigVersion.cmake \
"
