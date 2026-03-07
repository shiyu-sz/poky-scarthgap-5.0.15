# 继承基础的小型镜像
require recipes-core/images/core-image-minimal.bb

# 将你的应用和字体直接打包进去
IMAGE_INSTALL:append = " \
    qtbase \
    qtbase-plugins \
    qt-helloworld \
    lvgl-fbdev-benchmark \
    ttf-dejavu-sans \
    libinput \
"

# 添加 gdb 本身
IMAGE_INSTALL:append = " gdb"

# 【关键】添加调试符号，否则 gdb 只能看到地址，看不到源码函数名
# 这会显著增加镜像大小
IMAGE_FEATURES += "dbg-pkgs"

SUMMARY = "My Custom Minimal Qt5 Image"
LICENSE = "MIT"