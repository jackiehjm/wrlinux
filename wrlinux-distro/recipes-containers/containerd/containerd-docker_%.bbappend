FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
    file://docker-17.03.2-ce.tgz \
"

LIC_FILES_CHKSUM = "file://LICENSE.code;md5=aadc30f9c14d876ded7bedc0afd2d3d7"

do_compile() {
    :
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/docker/docker-containerd ${D}${bindir}/containerd
    install -m 755 ${WORKDIR}/docker/docker-containerd-ctr ${D}${bindir}/containerd-ctr
    install -m 755 ${WORKDIR}/docker/docker-containerd-shim ${D}${bindir}/containerd-shim

    ln -sf containerd ${D}/${bindir}/docker-containerd
    ln -sf containerd-shim ${D}/${bindir}/docker-containerd-shim
    ln -sf containerd-ctr ${D}/${bindir}/docker-containerd-ctr

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/containerd.service ${D}/${systemd_unitdir}/system

        # adjust from /usr/local/bin to /usr/bin/
        sed -e "s:/usr/local/bin/containerd:${bindir}/docker-containerd:g" -i ${D}/${systemd_unitdir}/system/containerd.service
    fi
}

INSANE_SKIP_${PN} = "already-stripped"
