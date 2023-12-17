FROM liferay/dxp:7.4.13-u102

COPY --chown=liferay:liferay /bundles/deploy mnt/liferay/deploy
COPY --chown=liferay:liferay /configs/docker/*.properties mnt/liferay/files
COPY --chown=liferay:liferay /bundles/osgi/modules/*.jar /opt/liferay/osgi/modules