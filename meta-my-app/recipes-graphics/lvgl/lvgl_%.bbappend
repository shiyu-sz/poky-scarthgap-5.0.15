
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://lv_conf.h"

# 将你的配置文件拷贝到源码目录，覆盖默认配置
do_configure:append() {
    cp ${WORKDIR}/lv_conf.h ${S}/lv_conf.h
}

# 1. 开启驱动宏
TARGET_CFLAGS:append = " -DLV_USE_LINUX_FBDEV=1 -DLV_USE_LINUX_EVDEV=1"

# 2. 确保 PACKAGECONFIG 也开启了（处理源文件编译）
PACKAGECONFIG:append = " linux-fbdev linux-evdev"
