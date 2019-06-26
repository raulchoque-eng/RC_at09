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
	s.vm.provision "shell", inline: "mkdir /home/ubuntu/jenkins_home; chown -R ubuntu:ubuntu /home/ubuntu/jenkins_home"
	s.vm.provision "docker" do |d|
	  d.pull_images "registry.jala.info/devops/jenkins/jenkins:2.150.3-alpine"
	  d.run "jenkins",
		image: "registry.jala.info/devops/jenkins/jenkins:2.150.3-alpine",
		args: "-p 80:8080 -p 50000:50000 -d -v /home/ubuntu/jenkins_home:/var/jenkins_home"
	end
	s.vm.provider :openstack do |os, override|
	  os.server_name = "AT09#{ENV['OS_INITIAL_NAME']}01"
      os.flavor = ENV['OS_FLAVOR']
	  override.vm.synced_folder '.', '/vagrant', disabled: true
	end  
  end
end
