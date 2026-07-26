#!/bin/bash
set -e
echo "Generating VLESS+Reality keys..."
mkdir -p ../keys
openssl genpkey -algorithm X25519 -out ../keys/private.pem
openssl pkey -in ../keys/private.pem -pubout -out ../keys/public.pem
PRIV_BASE64=$(openssl pkey -in ../keys/private.pem -text_pub -noout | grep -A1 "priv:" | tail -1 | xxd -r -p | base64 -w 0)
PUB_HEX=$(openssl pkey -in ../keys/public.pem -pubin -text | grep "pub:" -A1 | tail -1 | tr -d ' ' | tr -d ':')
SHORT_ID=$(openssl rand -hex 4 | tr '[:upper:]' '[:lower:]')
echo "Public key (hex): $PUB_HEX"
echo "Private key (base64): $PRIV_BASE64"
echo "Short ID: $SHORT_ID"
cat > ../keys/reality.env << ENV_EOF
PUBLIC_HEX=$PUB_HEX
PRIVATE_BASE64=$PRIV_BASE64
SHORT_ID=$SHORT_ID
ENV_EOF
