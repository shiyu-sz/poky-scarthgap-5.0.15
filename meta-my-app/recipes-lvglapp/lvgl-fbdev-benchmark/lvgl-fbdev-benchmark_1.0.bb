SUMMARY = "Simple LVGL Application for QEMU"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://main.c \
    file://mouse_cursor_icon.c \
    file://Makefile \
"

S = "${WORKDIR}"

DEPENDS = "lvgl libdrm"

# 在 lvgl-fbdev-benchmark_1.0.bb 中
# 确保 CFLAGS 包含了宏定义和头文件搜索路径
TARGET_CFLAGS:append = " -DLV_CONF_INCLUDE_SIMPLE -I${S}"
TARGET_LDFLAGS:append = " -Wl,--start-group -llvgl -llvgl_demos -lpthread -lm -Wl,--end-group"

# 关键：通过 EXTRA_OEMAKE 将 Yocto 的工具链变量传给 Makefile
EXTRA_OEMAKE = " \
    'CC=${CC}' \
    'CFLAGS=${CFLAGS}' \
    'LDFLAGS=${LDFLAGS}' \
"

do_compile() {
    # oe_runmake 会自动调用 make，并传入交叉编译参数
    # 如果你的 Makefile 需要特定参数，可以写成：oe_runmake TARGET=all
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/build/bin/lvgl_demo ${D}${bindir}/
}

FILES:${PN} = "${bindir}/lvgl_demo"