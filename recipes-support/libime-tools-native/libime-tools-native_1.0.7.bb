LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS = "fcitx5-tools-native boost python3-native"

SRC_URI = " \
	https://download.fcitx-im.org/fcitx5/libime/libime-${PV}.tar.xz;name=src \
	https://download.fcitx-im.org/data/lm_sc.3gm.arpa-20140820.tar.bz2;name=opengram_lm \
	https://download.fcitx-im.org/data/dict.utf8-20210402.tar.xz;name=opengram_dict \
	https://download.fcitx-im.org/data/table.tar.gz;name=table_dict \
"
SRC_URI[src.sha256sum] = "c75bde79842c195b53b88f1c4866e1b84dab376946dc990e05d49de369f5c8b5"
SRC_URI[opengram_lm.sha256sum] = "751bab7c55ea93a2cedfb0fbb7eb09f67d4da9c2c55496e5f31eb8580f1d1e2f"
SRC_URI[opengram_dict.sha256sum] = "818cfbb5a99ae5b40c2707b6158734f4a10196444853400cbd6b14505592d80d"
SRC_URI[table_dict.sha256sum] = "6196053c724125e3ae3d8bd6b2f9172d0c83b65b0d410d3cde63b7a8d6ab87b7"

S = "${WORKDIR}/libime-${PV}"

FILESEXTRAPATHS =. "${FILE_DIRNAME}/fcitx5-tools:"

inherit cmake pkgconfig python3native native

EXTRA_OECMAKE += " \
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

do_compile() {
    cmake --build ${B} --target libime_pinyindict
    cmake --build ${B} --target libime_tabledict
    cmake --build ${B} --target libime_slm_build_binary
}

do_install() {
    install -d ${D}/${bindir}
    install -d ${D}/${libdir}
    install -m 755 tools/libime_pinyindict ${D}/${bindir}/LibIME::pinyindict
    install -m 755 tools/libime_tabledict ${D}/${bindir}/LibIME::tabledict
    install -m 755 tools/libime_tabledict ${D}/${bindir}/LibIME::slm_build_binary
    install -m 644 src/libime/core/libIMECore.so* ${D}/${libdir}
    install -m 644 src/libime/pinyin/libIMEPinyin.so* ${D}/${libdir}
    install -m 644 src/libime/table/libIMETable.so* ${D}/${libdir}
}

BBCLASSEXTEND = "native nativesdk"
