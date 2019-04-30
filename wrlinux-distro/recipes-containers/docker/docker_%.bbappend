FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
    file://docker-17.03.2-ce.tgz \
"

PV = "17.03.2-ce"

do_install_append() {
    install -m 755 ${WORKDIR}/docker/docker ${D}${bindir}
    install -m 755 ${WORKDIR}/docker/dockerd ${D}${bindir}
    #install -m 755 ${WORKDIR}/docker/docker-init ${D}${bindir}
    install -m 755 ${WORKDIR}/docker/docker-proxy ${D}${bindir}

    sed -i '/ExecStart=/a ExecStartPost=/usr/sbin/iptables -P FORWARD ACCEPT' ${D}${systemd_unitdir}/system/docker.service
}

INSANE_SKIP_${PN} = "already-stripped"
