#!/bin/bash
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
KEYS_DIR="$REPO_ROOT/keys"

echo "Generating VLESS+Reality keys..."
mkdir -p "$KEYS_DIR"
openssl genpkey -algorithm X25519 -out "$KEYS_DIR/private.pem"
openssl pkey -in "$KEYS_DIR/private.pem" -pubout -out "$KEYS_DIR/public.pem"
PRIV_BASE64=$(openssl pkey -in "$KEYS_DIR/private.pem" -text_pub -noout | grep -A1 "priv:" | tail -1 | xxd -r -p | base64 -w 0)
PUB_HEX=$(openssl pkey -in "$KEYS_DIR/public.pem" -pubin -text | grep "pub:" -A1 | tail -1 | tr -d ' ' | tr -d ':')
SHORT_ID=$(openssl rand -hex 4 | tr '[:upper:]' '[:lower:]')
echo "Public key (hex): $PUB_HEX"
echo "Private key (base64): $PRIV_BASE64"
echo "Short ID: $SHORT_ID"
cat > "$KEYS_DIR/reality.env" << ENV_EOF
PUBLIC_HEX=$PUB_HEX
PRIVATE_BASE64=$PRIV_BASE64
SHORT_ID=$SHORT_ID
ENV_EOF
