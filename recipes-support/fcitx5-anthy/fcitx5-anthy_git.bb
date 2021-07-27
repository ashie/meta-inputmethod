LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "fcitx5 anthy fcitx5-tools-native"
RDPENDS = "fcitx5 libanthy0 anthy"

SRC_URI = "git://github.com/fcitx/fcitx5-anthy.git;protocol=https"
SRCREV = "ec6ef55e1fdbb876b244612d543f56051ed92c67"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
"

PV = "5.0.5+git${SRCPV}"
S = "${WORKDIR}/git"

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
