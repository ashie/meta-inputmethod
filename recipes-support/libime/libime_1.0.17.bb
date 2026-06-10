LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS = "fcitx5 fcitx5-tools-native boost python3-native libime-tools-native"
RDEPENDS:${PN} = "fcitx5 boost"

SRC_URI = " \
    https://download.fcitx-im.org/fcitx5/${BPN}/${BPN}-${PV}.tar.xz;name=src \
    https://download.fcitx-im.org/data/lm_sc.arpa-20220810.tar.xz;name=opengram_lm \
    https://download.fcitx-im.org/data/dict-20220810.tar.xz;name=opengram_dict \
    https://download.fcitx-im.org/data/table.tar.gz;name=table_dict \
"
SRC_URI[src.sha256sum] = "23f87b8104b9161bdc41fbac44294fef825d586260afc698f6a85ff20ea65407"
SRC_URI[opengram_lm.sha256sum] = "a11bc97d275adaf195f9bac854368ae06cdb4a0fe1eecf59db5ae580615db4fa"
SRC_URI[opengram_dict.sha256sum] = "971752f413188007e8d19158c11b85c955e25d7b321ec2275c4b3af6d8a85d26"
SRC_URI[table_dict.sha256sum] = "6196053c724125e3ae3d8bd6b2f9172d0c83b65b0d410d3cde63b7a8d6ab87b7"

SRC_URI:append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
    file://0002-Use-CMAKE_INSTALL_INCLUDEDIR-instead-of-CMAKE_INSTAL.patch \
"

inherit cmake pkgconfig python3native

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_TEST=OFF \
"

do_unpack[opengram_lm.noexec] = "1"
do_unpack[opengram_dict.noexec] = "1"
do_unpack[table_dict.noexec] = "1"
do_unpack_extra() {
    cp ${DL_DIR}/lm_sc.arpa-20220810.tar.xz ${S}/data/
    cp ${DL_DIR}/dict-20220810.tar.xz ${S}/data/
    cp ${DL_DIR}/table.tar.gz ${S}/data/
}
addtask unpack_extra after do_unpack before do_patch

FILES:${PN}-dev += "${libdir}/cmake"
