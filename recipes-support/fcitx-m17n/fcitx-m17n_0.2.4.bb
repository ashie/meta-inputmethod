# Recipe created by recipetool
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS = "fcitx fcitx-tools-native m17n-lib"
RDEPENDS_${PN} = "fcitx fcitx-data fcitx-modules m17n-lib"

SRC_URI = "https://download.fcitx-im.org/fcitx-m17n/fcitx-m17n-${PV}.tar.xz"

SRC_URI[md5sum] = "d9c3e77914bd19d235d4d74fcea8df89"
SRC_URI[sha256sum] = "cf82158b907ba6b79aad3e4c26f9e0e2457a270619548adc31e9f77412144597"

# NOTE: unable to map the following CMake package dependencies: M17N Fcitx
inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE += "-DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DFCITX_TOOL_BINARY_DIR=${RECIPE_SYSROOT_NATIVE}/${nonarch_libdir}/fcitx/ \
"
FILES_${PN} += "${nonarch_libdir}/fcitx/fcitx-m17n.so \
	${datadir}/fcitx \
"
