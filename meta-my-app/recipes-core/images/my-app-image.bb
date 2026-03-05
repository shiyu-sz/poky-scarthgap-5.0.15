# 继承基础的小型镜像
require recipes-core/images/core-image-minimal.bb

# 将你的应用和字体直接打包进去
IMAGE_INSTALL:append = " \
    qtbase \
    qtbase-plugins \
    qt-helloworld \
    ttf-dejavu-sans \
    libinput \
"

SUMMARY = "My Custom Minimal Qt5 Image"
LICENSE = "MIT"