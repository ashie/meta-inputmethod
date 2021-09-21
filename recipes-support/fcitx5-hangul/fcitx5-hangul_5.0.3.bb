LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "fcitx5 fcitx5-tools-native libhangul"
RDEPENDS_${PN} = "fcitx5 libhangul"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "e02d3d59e22a60e65099eaa0e5e394481a770a401c83b9979f754678c100f1e6"

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
    ${libdir}/fcitx5/hangul.so \
    ${datadir}/icons \
    ${datadir}/fcitx5 \
"
