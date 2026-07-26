package xray
import (
	"github.com/xtls/xray-core/core"
	_ "github.com/xtls/xray-core/main/distro/all"
)
var instance *core.Instance
func StartXray(configJSON string) error {
	if instance != nil { return nil }
	config, err := core.LoadConfig("json", configJSON)
	if err != nil { return err }
	server, err := core.New(config)
	if err != nil { return err }
	instance = server
	return instance.Start()
}
func StopXray() {
	if instance != nil {
		instance.Close()
		instance = nil
	}
}
