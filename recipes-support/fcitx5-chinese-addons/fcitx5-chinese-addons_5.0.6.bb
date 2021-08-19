LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = " \
    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
    file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68 \
"

DEPENDS = "fcitx5 fcitx5-tools-native fmt curl opencc libime libime-tools-native"
RDPENDS = "fcitx5 fmt curl opencc libime"

SRC_URI = " \
    https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz;name=src \
    https://download.fcitx-im.org/data/py_stroke-20121124.tar.gz;name=py_stroke \
    https://download.fcitx-im.org/data/py_table-20121124.tar.gz;name=py_table \
"
SRC_URI[src.sha256sum] = "061e71ef55524e51334ff29e9f93a677b7453f7af48181db0bf3ae851a0ee011"
SRC_URI[py_stroke.sha256sum] = "8eb128a9bfa43952e67cf2fcee1fd134c6f4cfd317bc2f6c38a615f5eb64e248"
SRC_URI[py_table.sha256sum] = "42146ac97de6c13d55f9e99ed873915f4c66739e9c11532a34556badf9792c04"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
    file://0003-Work-arround-to-execute-libime_pinyindict-for-cross-.patch \
"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
    -DENABLE_GUI=OFF \
    -DENABLE_TEST=OFF \
"

do_unpack[py_stroke.noexec] = "1"
do_unpack[py_table.noexec] = "1"
do_unpack_extra() {
    cp ${DL_DIR}/py_stroke-20121124.tar.gz ${S}/modules/pinyinhelper/
    cp ${DL_DIR}/py_table-20121124.tar.gz ${S}/modules/pinyinhelper/
}
addtask unpack_extra after do_unpack before do_patch

FILES_${PN} += "\
    ${libdir}/fcitx5/*.so \
    ${datadir}/icons \
    ${datadir}/fcitx5 \
"
