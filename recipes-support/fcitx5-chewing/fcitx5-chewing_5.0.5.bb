LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "fcitx5 fcitx5-tools-native libchewing"
RDPENDS = "fcitx5 libchewing"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "9c2f208796198daa6c37d9918929f0301792c1611afbc14155ef4dd69d699163"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
"

FILES_${PN} += "\
    ${libdir}/fcitx5/chewing.so \
    ${datadir}/icons \
    ${datadir}/fcitx5 \
"
