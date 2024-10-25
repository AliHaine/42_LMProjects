from PIL import Image, ExifTags

img = Image.open("f.png")
img_exif = img.getexif()

if img_exif is None:
    print('Sorry, image has no exif data.')
else:
    for key, val in img_exif.items():
        if key in ExifTags.TAGS:
            print(f'{ExifTags.TAGS[key]}:{val}')
        else:
            print(f'{key}:{val}')