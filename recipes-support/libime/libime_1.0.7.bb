LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS = "fcitx5 fcitx5-tools-native boost python3-native"
RDPENDS = "fcitx5 boost"

SRC_URI = " \
	https://download.fcitx-im.org/fcitx5/${PN}/${PN}-${PV}.tar.xz;name=src \
	https://download.fcitx-im.org/data/lm_sc.3gm.arpa-20140820.tar.bz2;name=opengram_lm \
	https://download.fcitx-im.org/data/dict.utf8-20210402.tar.xz;name=opengram_dict \
	https://download.fcitx-im.org/data/table.tar.gz;name=table_dict \
"
SRC_URI[src.sha256sum] = "c75bde79842c195b53b88f1c4866e1b84dab376946dc990e05d49de369f5c8b5"
SRC_URI[opengram_lm.sha256sum] = "751bab7c55ea93a2cedfb0fbb7eb09f67d4da9c2c55496e5f31eb8580f1d1e2f"
SRC_URI[opengram_dict.sha256sum] = "818cfbb5a99ae5b40c2707b6158734f4a10196444853400cbd6b14505592d80d"
SRC_URI[table_dict.sha256sum] = "6196053c724125e3ae3d8bd6b2f9172d0c83b65b0d410d3cde63b7a8d6ab87b7"

SRC_URI_append = "\
    file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
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
    cp ${DL_DIR}/lm_sc.3gm.arpa-20140820.tar.bz2 ${S}/data/
    cp ${DL_DIR}/dict.utf8-20210402.tar.xz ${S}/data/
    cp ${DL_DIR}/table.tar.gz ${S}/data/
}
addtask unpack_extra after do_unpack before do_patch

#FILES_${PN} += "\
#    ${libdir}/fcitx5/hangul.so \
#    ${datadir}/icons \
#    ${datadir}/fcitx5 \
#"
