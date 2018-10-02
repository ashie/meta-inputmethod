# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1 \
                    file://attic/modules/COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "git://github.com/KDE/extra-cmake-modules.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "2c2bb8f4766fec5e391839dbc093b638acee3a22"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: Qt5Quick Qt5LinguistTools QCollectionGenerator Qt5Core PythonModuleGeneration Sphinx
inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

FILES_${PN} = "${datadir}/ECM/*"




