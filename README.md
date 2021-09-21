OpenEmbedded/Yocto BSP layer for inputmethod
=============================================

This layer provides recipes for multilingual input methods used with
OpenEmbedded and/or Yocto.

This layer depends on meta-openembedded, poky, and qt5 layers.

Contributing
------------

Bug reports and pull requests are welcome on GitLab at
https://gitlab.com/clear-code/meta-inputmethod.

Recipes
-------

### fcitx5 and fcitx5-*

[Fcitx5](https://fcitx-im.org/wiki/Fcitx_5) and its modules.
Mainly for Wayland environment.

* fcitx5: Input method framework
* fcitx5-anthy: Japanese input method
* fcitx5-chewing: Traditional Chinese (Chewing) input method
* fcitx5-chinese-addons: Simplified Chinese (Pinyin and table) input methods
* fcitx5-hangul: Korean (Hangul) input method
* fcitx5-m17n: Multilingual input methods

### fcitx and fcitx-*

[Fcitx4](https://fcitx-im.org/wiki/Fcitx) and its modules.
Mainly for X11 environment.

* fcitx: Input method framework and Chinese (Pinyin and table) input methods
* fcitx-anthy: Japanese input method
* fcitx-chewing: Traditional Chinese (Chewing) input method
* fcitx-hangul: Korean (Hangul) input method
* fcitx-m17n: Multilingual input methods

### ibus and ibus-*

Although we don't yet publish them, we already have these recipes internally.
Please contact us if you need them. We'll ensure to publish them if there are
actual needs.

FYI: On our test, Fcitx was superior to IBus at many points.

Quick Start
-----------

### Fcitx5 on Weston

#### How to build

* Clone this layer:
  `git clone git@gitlab.com:clear-code/meta-inputmethod.git `
* Add meta-inputmethod to you bblayers.conf:
  `bitbake-layers add-layer /path/to/meta-inputmethod`
* Add following lines to your local.conf:
```
IMAGE_INSTALL_append = " fcitx5-anthy "          # Japanese
IMAGE_INSTALL_append = " fcitx5-chewing "        # Traditional Chinese
IMAGE_INSTALL_append = " fcitx5-chinese-addons " # Simplified Chinese
IMAGE_INSTALL_append = " fcitx5-hangul "         # Korean
IMAGE_INSTALL_append = " fcitx5-m17n "           # Other launguages
IMAGE_INSTALL_append = " \
  source-han-sans-cn-fonts \
  source-han-sans-jp-fonts \
  source-han-sans-kr-fonts \
"
```
* Build: `bitbake core-image-weston`

#### How to run

* Add following lines to your /etc/xdg/weston/weston.ini
```
[input-method]
path=/usr/bin/fcitx5
```
* Add following lines to you /etc/xdg/fcitx5/profile
```
[Groups/0]
Name=Default
Default Layout=us
DefaultIM=anthy

[Groups/0/Items/0]
Name=keyboard-us

[Groups/0/Items/1]
Name=anthy

[Groups/0/Items/2]
Name=chewing

[Groups/0/Items/3]
Name=pinyin

[Groups/0/Items/4]
Name=hangul
```
* Run weston

#### How to use with applications

Fcitx5 provided by this recipe is confirmed with weston-editor and
chromium-ozone-wayland. It will also work with other applications
that supports text-input-v1 protocol.

GTK applications aren't supported yet because GTK supports only text-input-v3
and gtk-text-input protocols. On the other hand, we are preparing a patch at
[gtk3-wayland-text-input-v1 branch](./-/tree/gtk3-wayland-text-input-v1) to
support v1 protocol.

Qt applications aren't confirmed yet.

You can enable input method by `Ctrl + Space` on such applications, and switch
input methods by `Ctrl + Shift`.

If DBus's session bus is enabled, you can switch IMs also by `fcitx5-remote`
command. e.g.) `fcitx5-remote -s anthy`
