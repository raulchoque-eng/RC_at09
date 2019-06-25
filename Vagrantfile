require 'vagrant-openstack-provider'

Vagrant.configure('2') do |config|
  config.ssh.username = 'ubuntu'
  config.ssh.private_key_path = ENV['OS_PRIVATE_KEY_PATH']
  
  config.vm.provider :openstack do |os, override|
    os.identity_api_version = ENV['OS_IDENTITY_API_VERSION']
	os.openstack_auth_url = ENV['OS_AUTH_URL']
	os.domain_name = ENV['OS_DOMAIN_NAME']
	os.username = ENV['OS_USERNAME']
	os.password = ENV['OS_PASSWORD']
	os.tenant_name = ENV['OS_TENANT_NAME']
	os.project_name = ENV['OS_PROJECT_NAME']
	os.keypair_name = ENV['OS_KEY_PAIR_NAME']
	os.region = ENV['OS_REGION_NAME']
	os.image = ENV['OS_IMAGE']
  end
  
  config.vm.define 'linux-server-1' do |s|
	s.vm.provision "shell", path: "install_jenkins.sh"
	s.vm.provider :openstack do |os, override|
	  os.server_name = "AT09#{ENV['OS_INITIAL_NAME']}01"
      os.flavor = ENV['OS_FLAVOR']
	  override.vm.synced_folder '.', '/vagrant', disabled: true
	end  
  end
end
