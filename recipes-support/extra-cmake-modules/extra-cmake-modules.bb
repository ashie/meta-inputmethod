# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   docs/module/ECMCheckOutboundLicense.rst
#   modules/ECMCheckOutboundLicense.cmake
#   modules/check-outbound-license.py
#   tests/ECMCheckOutboundLicenseTest/testdata/GPL-2.0-only.cpp
#   tests/ECMCheckOutboundLicenseTest/testdata/GPL-2.0-or-later.cpp
#   tests/ECMCheckOutboundLicenseTest/testdata/GPL-3.0-only.cpp
#   tests/ECMCheckOutboundLicenseTest/testdata/LGPL-2.1-or-later.cpp
#   tests/ECMCheckOutboundLicenseTest/testdata/LGPL-3.0-only.cpp
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
SUMMARY = "Extra modules and scripts for CMake"

LICENSE = "BSD-3-Clause & Unknown"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1 \
                    file://docs/module/ECMCheckOutboundLicense.rst;md5=093f1e87e09bb89f660f7d4231d3e27f \
                    file://modules/ECMCheckOutboundLicense.cmake;md5=8b069345a2b2ebdbe2d108eea28e190c \
                    file://modules/check-outbound-license.py;md5=30f68036ed3ba13a282d3c07d66ae09b \
                    file://tests/ECMCheckOutboundLicenseTest/testdata/GPL-2.0-only.cpp;md5=19a89d1bbe6b2d230e22ef40172441f1 \
                    file://tests/ECMCheckOutboundLicenseTest/testdata/GPL-2.0-or-later.cpp;md5=4e1b403ed8a88cd2e66a31ea125f040d \
                    file://tests/ECMCheckOutboundLicenseTest/testdata/GPL-3.0-only.cpp;md5=e3d2ae9a4dafcb0598ec166ae3b2d570 \
                    file://tests/ECMCheckOutboundLicenseTest/testdata/LGPL-2.1-or-later.cpp;md5=aa9f1063b0beb045b9740aeb569c008a \
                    file://tests/ECMCheckOutboundLicenseTest/testdata/LGPL-3.0-only.cpp;md5=3172962dc0da0fcf11c750f68ba1f21e \
                    file://attic/modules/COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "git://github.com/KDE/extra-cmake-modules.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "04f4675cbb874b53f4e6024ecea5b0d9c472bf7c"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: PythonModuleGeneration QCollectionGenerator Sphinx Qt5LinguistTools Qt5Quick Qt5Core
inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE += "-DBUILD_TESTING=off"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native nativesdk"
