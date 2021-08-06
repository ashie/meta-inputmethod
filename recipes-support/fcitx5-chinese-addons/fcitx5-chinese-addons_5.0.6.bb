LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = " \
    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
    file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68 \
"

DEPENDS = "fcitx5 fcitx5-tools-native fmt curl opencc libpinyin"
RDPENDS = "fcitx5 fmt curl opencc libpinyin"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "061e71ef55524e51334ff29e9f93a677b7453f7af48181db0bf3ae851a0ee011"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
    -DENABLE_GUI=OFF \
"

#FILES_${PN} += "\
#    ${libdir}/fcitx5/anthy.so \
#    ${datadir}/icons \
#    ${datadir}/fcitx5 \
#"
