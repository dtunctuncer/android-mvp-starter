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
os.chdir(os.path.join(project_dir,"app","src","main","java"))

root_dst_dir = os.path.join(project_dir,"app","src","main","java",package_dir)
root_src_dir = os.path.join(project_dir,"app","src","main","java")

if '{{ cookiecutter.splash_screen }}' != 'y':
    shutil.rmtree('splash')

base = os.path.join(root_src_dir,"base")
di = os.path.join(root_src_dir,"di")
splash = os.path.join(root_src_dir,"splash")
utils = os.path.join(root_src_dir,"utils")

shutil.move('Application.java',os.path.join(project_dir,"app","src","main","java",package_dir,"Application.java"))
shutil.move('MainActivity.java',os.path.join(project_dir,"app","src","main","java",package_dir,"MainActivity.java"))

def moverecursively(source_folder, destination_folder):
    basename = os.path.basename(source_folder)
    dest_dir = os.path.join(destination_folder, basename)
    if not os.path.exists(dest_dir):
        shutil.move(source_folder, destination_folder)
    else:
        dst_path = os.path.join(destination_folder, basename)
        for root, dirs, files in os.walk(source_folder):
            for item in files:
                src_path = os.path.join(root, item)
                if os.path.exists(dst_file):
                    os.remove(dst_file)
                shutil.move(src_path, dst_path)
            for item in dirs:
                src_path = os.path.join(root, item)
                moverecursively(src_path, dst_path)

moverecursively(base,root_dst_dir)
moverecursively(di,root_dst_dir)
moverecursively(utils,root_dst_dir)
if '{{ cookiecutter.splash_screen }}' == 'y':
    moverecursively(splash,root_dst_dir)




#for src_dir, dirs, files in os.walk(root_src_dir):
#    dst_dir = src_dir.replace(root_src_dir, root_dst_dir, 1)
#    if not os.path.exists(dst_dir):
#        os.makedirs(dst_dir)
#    for file_ in files:
#        src_file = os.path.join(src_dir, file_)
#        dst_file = os.path.join(dst_dir, file_)
#        if os.path.exists(dst_file):
#            os.remove(dst_file)
#        shutil.move(src_file, dst_dir)

#shutil.move('base',os.path.join(project_dir,"app","src","main","java",package_dir,"activities","MainActivity.java"))
#shutil.move('di',os.path.join(project_dir,"app","src","main","java",package_dir,"Application.java"))
#shutil.move('MainFragment.java',os.path.join(project_dir,"app","src","main","java",package_dir,"fragments","MainFragment.java"))
#shutil.move('AboutFragment.java',os.path.join(project_dir,"app","src","main","java",package_dir,"fragments","AboutFragment.java"))
#shutil.move('BaseActivity.java',os.path.join(project_dir,"app","src","main","java",package_dir,"helpers","BaseActivity.java"))
