LICENSE = "LGPLv2.1 & MIT"
LIC_FILES_CHKSUM = "file://src/xlibi18n/lcUniConv/COPYRIGHT;md5=2715cd5c86722a098d6b97148d1e6936 \
                    file://LICENSES/LGPL-2.1-only.txt;md5=fabba2a3bfeb22a6483d44e9ae824d3f"

SRC_URI = "https://download.fcitx-im.org/fcitx5/xcb-imdkit/xcb-imdkit-${PV}.tar.xz"
SRC_URI[md5sum] = "9b4f2914127779114a4f3067a53cde3f"
SRC_URI[sha1sum] = "b32b5e070ca12135cd19b752fb2455f471b5ec29"
SRC_URI[sha256sum] = "09c2626ea29fbd6a8c650144ca126b7bdd6365258b7c39508028bfdca6dca8e8"
SRC_URI[sha384sum] = "73d0acdf8a4754c75afa12bf6677174876b3ddc4122d40fc62546fefeec003fd428439b9f76df9a96cdeeffc4ad25b47"
SRC_URI[sha512sum] = "df15dbe8363f89259f59b4afb81befd3be88173362f78c3b6cf0c7cdb2bdca75b352b779e0e7a91bb814a6afe59c4cc8acc946ce96721ca376438a9e8f3b4e80"

DEPENDS = "extra-cmake-modules libxcb xcb-util xcb-util-keysyms"

inherit cmake

EXTRA_OECMAKE = ""

FILES_${PN}-dev += "${libdir}/cmake/XCBImdkit"
