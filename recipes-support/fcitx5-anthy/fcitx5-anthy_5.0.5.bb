LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "fcitx5 anthy fcitx5-tools-native"
RDEPENDS_${PN} = "fcitx5 libanthy0 anthy"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "22364003e737cbe4ea6eaa83d9d274a8df8e38dea61d8f4576560ee7d5eaf44d"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
    file://0003-Add-UI-update-when-clicking-candidate.patch \
"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
"

FILES_${PN} += "\
    ${libdir}/fcitx5/anthy.so \
    ${datadir}/icons \
    ${datadir}/fcitx5 \
"
