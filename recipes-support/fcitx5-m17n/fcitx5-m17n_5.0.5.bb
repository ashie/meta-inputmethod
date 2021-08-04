LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS = "fcitx5 fcitx5-tools-native m17n-lib"
RDPENDS = "fcitx5 m17n-lib"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "292deb065e571b38eacc28007e1a6b69d27d7332aa2708055a645d98549dd69f"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
    -DENABLE_TEST=OFF \
"

FILES_${PN} += "\
    ${libdir}/fcitx5/m17n.so \
    ${datadir}/icons \
    ${datadir}/fcitx5 \
"
