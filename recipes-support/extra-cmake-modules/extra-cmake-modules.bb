SUMMARY = "Extra modules and scripts for CMake"

LICENSE = "BSD-2-Clause & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = " \
    file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1 \
    file://LICENSES/BSD-2-Clause.txt;md5=63d6ee386b8aaba70b1bf15a79ca50f2 \
    file://LICENSES/BSD-3-Clause.txt;md5=954f4d71a37096249f837652a7f586c0 \
    file://LICENSES/MIT.txt;md5=38aa75cf4c4c87f018227d5ec9638d75 \
"

SRC_URI = " \
    git://github.com/KDE/extra-cmake-modules.git;protocol=https \
    file://0001-Use-code-instead-of-public-code-for-wayland-scanner.patch \
"

PV = "1.0+git${SRCPV}"
SRCREV = "04f4675cbb874b53f4e6024ecea5b0d9c472bf7c"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native nativesdk"
