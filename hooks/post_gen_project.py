#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil

project_dir = os.getcwd()

package_dir = '{{ cookiecutter.package_name }}'.replace('.', '/')

os.chdir(os.path.join("app","src","androidTest","java"))
os.makedirs(package_dir)
shutil.move('ApplicationTest.java', package_dir + '/ApplicationTest.java')

os.chdir(os.path.join(project_dir,"app","src","main","java"))
os.makedirs(package_dir)


os.chdir(os.path.join(project_dir,"app","src","test","java"))
os.makedirs(package_dir)
shutil.move('ExampleUnitTest.java', package_dir + '/ExampleUnitTest.java')

os.chdir(os.path.join(project_dir,"app","src","main","java",package_dir))
os.makedirs('activities')
os.makedirs('adapters')
os.makedirs('fragments')
os.makedirs('helpers')
os.makedirs('library')
os.makedirs('model')
os.makedirs('services')
os.chdir(os.path.join(project_dir,"app","src","main","java"))

if '{{ cookiecutter.splash_screen }}' == 'y':
    shutil.move('SplashActivity.java',os.path.join(project_dir,"app","src","main","java",package_dir,"activities","SplashActivity.java"))
else:
    os.remove('SplashActivity.java')

shutil.move('MainActivity.java',os.path.join(project_dir,"app","src","main","java",package_dir,"activities","MainActivity.java"))
shutil.move('Application.java',os.path.join(project_dir,"app","src","main","java",package_dir,"Application.java"))
shutil.move('MainFragment.java',os.path.join(project_dir,"app","src","main","java",package_dir,"fragments","MainFragment.java"))
shutil.move('AboutFragment.java',os.path.join(project_dir,"app","src","main","java",package_dir,"fragments","AboutFragment.java"))
shutil.move('BaseActivity.java',os.path.join(project_dir,"app","src","main","java",package_dir,"helpers","BaseActivity.java"))